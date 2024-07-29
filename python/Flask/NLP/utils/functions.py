import joblib
import ast
import math

from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
from nltk.stem import WordNetLemmatizer
from nltk.corpus import wordnet

model = joblib.load('model/news_classification.pkl')

Category_class=['business', 'entertainment', 'politics', 'sport', 'tech']
tfidf = joblib.load('model/tfidf.pkl')

with open('tfidf/new_idf.txt') as f:
     idf_load=f.read()
idf_load=ast.literal_eval(idf_load)

def calc_tf_idf(txt,idf):
    idf=idf
    
    tf_idf={}
    word_count={}
    col=tfidf.get_feature_names_out()

    for ch in col:
        tf_idf[ch]=0
        word_count[ch]=0

    #Calculating tf
    words = txt.split()
    for ch in words:
        if ch in col:
            if ch in word_count:
                word_count[ch] += 1
            else:
                word_count[ch] = 1
   
    rough_tfidf=list(col)
    for keys in word_count.keys():
        tf_idf[keys]=idf[keys]*word_count[keys]
        if keys in rough_tfidf:
            index=rough_tfidf.index(keys)
            rough_tfidf[index]=tf_idf[keys]
    norm=0
    for i in range(0,len(rough_tfidf)):
        norm+=rough_tfidf[i]**2
    if norm==0:
        norm=1
    for i in range(0,len(rough_tfidf)):
        rough_tfidf[i]=round(rough_tfidf[i]/math.sqrt(norm),8)
    return rough_tfidf

def count_word(word):
    cnt=word.count(" ")+1
    return cnt

def predict_news_pickle(txt):
    #process text
    text=preprocess_text(txt)
    #calculate tfidf
    tf_idf=calc_tf_idf(text,idf_load)
    #Validate if it is actually news
    if all(i <.05 for i in tf_idf) or count_word(txt)<0:
        print("Cannot classify")
    else:
        index=model.predict([tf_idf])
        return Category_class[int(index)]

def preprocess_text(text):
    text=str(text)
    #lowercasing
    text=text.lower()
    #Remove Stop Words
    stop_words=set(stopwords.words('english'))
    word_tokens = word_tokenize(text)
    filtered_list = [w for w in word_tokens if not w in stop_words]
    
    
    #Remove numbers and special Symbols
    #words like 100m 2m were not removed so using this
    num=['0','1','2','3','4','5','6','7','8','9']
    num_filter=[]
    for i in range(0,len(filtered_list)):
        for j in range(0,len(num)):
            if num[j] in filtered_list[i]:
                num_filter.append(filtered_list[i])
                break
    
    for filter in num_filter:
        filtered_list.remove(filter)
                
    filtered_list = [w for w in filtered_list if w.isalnum()]
    filtered_list=  [w for w in filtered_list if not w.isdigit()]
    
    
    
    #Lematizing
    wordnet_lemmatizer=WordNetLemmatizer()
    lemmatized_list=[wordnet_lemmatizer.lemmatize(w,wordnet.VERB) for w in filtered_list]
    lemmatized_string=' '.join(lemmatized_list)
    
    return lemmatized_string


