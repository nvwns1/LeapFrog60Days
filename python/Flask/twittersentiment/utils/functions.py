import joblib
import re
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
from nltk.stem import PorterStemmer

label_mapping = {0: "negative", 2: "neutral", 4: "positive"}


# Removing @ from the tweet
def remove_usernames(text):
    return re.sub(r"@\w+", "", text)


def remove_hashtags(text):
    return re.sub(r"#", "", text)


def clean_text(text):
    # Removing URLs
    text = re.sub(r"http\S+|www\S+|https\S+", "", text, flags=re.MULTILINE)
    # Removing special characters and numbers
    text = re.sub(r"\W", " ", text)
    text = re.sub(r"\d", "", text)
    # Removing extra spaces
    text = re.sub(r"\s+", " ", text).strip()
    return text


def tokenize_text(text):
    return word_tokenize(text)


def case_folding(text):
    return text.lower()


def remove_stopwords(tokens):
    stop_words = set(stopwords.words("english"))
    return [word for word in tokens if word not in stop_words]


def stem_tokens(tokens):
    stemmer = PorterStemmer()
    return [stemmer.stem(word) for word in tokens]


def preprocess_text(text):
    text = remove_usernames(text)
    text = remove_hashtags(text)
    text = clean_text(text)
    text = case_folding(text)
    tokens = tokenize_text(text)
    tokens = remove_stopwords(tokens)
    tokens = stem_tokens(tokens)
    return " ".join(tokens)


model1 = joblib.load("model/model.pkl")
vectorizer1 = joblib.load("model/vectorizer.pkl")


def predict(new_tweets):
    new_tweets_cleaned = [preprocess_text(new_tweets)]

    new_tweets_tfidf = vectorizer1.transform(new_tweets_cleaned)
    predictions = model1.predict(new_tweets_tfidf)
    predictedLabel = label_mapping[predictions[0]]
    return predictedLabel
