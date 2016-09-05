import theano
a = theano.tensor.vector() # declare variable
out = a + a ** 10               # build symbolic expression
f = theano.function([a], out)   # compile function
print(f([0, 1, 2]))