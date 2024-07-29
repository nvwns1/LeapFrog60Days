from flask import Flask, render_template, request, redirect, url_for
from utils.functions import predict_news_pickle


app = Flask(__name__)


@app.route('/')
def home():
    return render_template('index.html')

@app.route('/classify', methods=['POST'])
def classify():
    text = request.form['news']
    prediction = predict_news_pickle(text)
    print(text)
    return redirect(url_for('result', prediction=prediction))


@app.route("/result")
def result():
    prediction = request.args.get('prediction')
    return render_template('result.html', prediction=prediction)

if __name__ == '__main__':
    app.run(debug=True)