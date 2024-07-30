from flask import Flask, request, render_template,jsonify
from utils.functions import predict

app = Flask(__name__)

@app.route("/")
def index():
    return render_template('index.html')


@app.route("/classify", methods=['POST'])
def classify():
    predictedLabel = ""
    data = request.get_json() 
    tweet = data.get('tweets', '')
    model_type = data.get('type', '')
    
    if model_type == 'model1':
        predictedLabel = predict(tweet)
        result = f"Prediction with model1"
    elif model_type == 'model2':
        result = f"Pending with svm model"
    else:
        result = f"Invalid model type selected."
    return jsonify({"result": result, "predictedLabel": predictedLabel})


if(__name__ == '__main__'):
    app.run(debug=True)