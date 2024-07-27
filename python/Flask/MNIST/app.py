from flask import Flask, render_template, request, redirect, url_for
import numpy as np
from PIL import Image
import pickle

app = Flask(__name__)

with open('model/svm_mnist.pkl', 'rb') as f:
    svc = pickle.load(f)

# classication function
def classify_image(image):
    image = image.convert('L').resize((28, 28))
    img_array = np.array(image)
    img_array = img_array.flatten()
    prediction = svc.predict([img_array])
    return prediction[0]

# Route for Home Page
@app.route('/')
def home():
    return render_template('index.html')

# Route for image upload and prediction
@app.route('/classify', methods=['POST'])
def classify():
    if 'file' not in request.files:
        return 'No file part'
    
    file = request.files['file']
    if file.filename == '':
        return 'No selected file'
    if file:
        image = Image.open(file)
        prediction = classify_image(image)
        image.save('static/uploaded_image.png') 
        return redirect(url_for('result', prediction=prediction))
    
@app.route('/upload')
def result():
    prediction = request.args.get('prediction')
    return render_template('result.html', prediction=prediction, image_url='static/uploaded_image.png')

if __name__ == '__main__':
    app.run(debug=True)