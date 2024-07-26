import base64
import numpy as np
import cv2

def resize_image(img_base64, size):
    img_data = base64.b64decode(img_base64)
    nparr = np.frombuffer(img_data, np.uint8)
    img = cv2.imdecode(nparr, cv2.IMREAD_COLOR)

    # Resize the image
    resized_image = cv2.resize(img, (size, size))

    # Encode the resized image
    _, img_encoded = cv2.imencode('.jpg', resized_image)
    resized_base64 = base64.b64encode(img_encoded).decode('utf-8')

    return resized_base64