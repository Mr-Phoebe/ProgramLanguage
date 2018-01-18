import numpy
import theano.tensor as T
from theano import function
x = T.dscalar('x')
y = T.dscalar('y')
z = x + y
f = function([x, y], z)
print f(2, 3)
print numpy.allclose(f(16.3, 12.1), 28.4)
'''
# The first step is to define two symbols (Variables) representing
# the quantities that you want to add.
# Note that from now on, we will use the term Variable to mean symbol
# in other words, x, y, z are all Variable objects.
# The output of the function f is a numpy.ndarray with zero dimensions.
'''