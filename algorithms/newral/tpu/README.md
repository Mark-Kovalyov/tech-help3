# TPU

## Nvidia

* https://www.nvidia.com/ru-ru/data-center/tesla-v100/

## Google  

* https://cloud.google.com/tpu
* https://coral.ai/products/#production-products
* https://coral.ai/docs/dev-board-mini/datasheet/

## PyCoral API
```
git clone https://github.com/google-coral/pycoral.git
bash examples/install_requirements.sh classify_image.py
python3 examples/classify_image.py \
--model test_data/mobilenet_v2_1.0_224_inat_bird_quant_edgetpu.tflite \
--labels test_data/inat_bird_labels.txt \
--input test_data/parrot.jpg
```

## In Development

* tensorflow
* pytorch
* keras

```
import tensorflow as tf
```

## NVidia software libs

* https://developer.nvidia.com/deep-learning-software
* https://developer.nvidia.com/cudnn
* TensorRRT https://developer.nvidia.com/tensorrt
  * pytorch
  * TensorFlow
  * ONNX
  * Matlab
