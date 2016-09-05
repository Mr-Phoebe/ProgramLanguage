import numpy
import theano.tensor as T
from theano import function
x = T.dmatrix('x')
y = T.dmatrix('y')
z = x + y
f = function([x, y], z)
print f([[1, 2], [3, 4]], [[10, 20], [30, 40]])
print f(numpy.array([[1, 2], [3, 4]]), numpy.array([[10, 20], [30, 40]]))