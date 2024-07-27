from flask import Flask, request, render_template

app = Flask(__name__)

@app.route('/hello')
def home(): 
    return 'Hello, World!'

@app.route('/get/<user>')
def name(user):
    return 'Hello, ' + user

@app.route('/post/',methods=['POST'])
def json_example():
    info={}
    data=request.get_json()
    a=data['first_num']
    b=data['second_num']
    sum=a+b
    info['input']=[a,b]
    info['sum']=sum
    
    '''return jsonify({
        "input":info,
        "sum":sum
        })'''
    return info

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/add', methods=['POST'])
def add_numbers():
    
    first_num = int(request.form['first_num'])
    second_num = int(request.form['second_num'])
    sum_result = first_num + second_num

    return render_template('result.html', first_num=first_num, second_num=second_num, sum_result=sum_result)

if __name__ == '__main__':
    app.run(debug=True)
