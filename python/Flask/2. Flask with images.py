from flask import Flask, render_template, request, redirect, flash
import base64

from utils.function import *

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('upload.html')

@app.route('/upload', methods=['POST'])
def upload():
    if 'file' not in request.files:
        flash('No file part')
        return redirect(request.url)
    
    file = request.files['file']

    if file.filename == '':
        flash('No selected file')
        return redirect(request.url)
    
    if file:
        image = file.read()
        encoded_image = base64.b64encode(image).decode('utf-8')
        return render_template('resize.html', image=encoded_image)
    
    flash('Error processing file')
    return redirect(request.url)




@app.route('/process', methods=['POST'])
def process():
    size = int(request.form['size'])
    image = request.form['image']

    resized_base64 = resize_image(image, size)
    return render_template('result_image.html', image=resized_base64)

if __name__ == '__main__':
    app.run(debug=True)