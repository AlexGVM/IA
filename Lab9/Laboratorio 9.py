#!/usr/bin/env python
# coding: utf-8

# ## ALEXANDER VILLATORO 1182118  11/4/2021 

# In[1]:


import numpy as np
import pandas as pd
data = np.random.seed(2131982)
data = np.random.randint(1,101, size=(10, 10))
print(data)
print("Media aritmetica")
print("La media aritmetica de la matriz es", data.mean())
print("")
print("Mediana")
print("La mediana de la matriz es", np.median(data))
print("")
print("Desviación típica")
print("La desviación típica de la matriz es", data.std())
print("")
print("Varianza")
print("La varianza de la matriz es", data.var())
print("")


# In[2]:


print("Media aritmética de cada fila")
for i,fila in enumerate(data): #for de cada fila
    print("La media aritmetica de cada fila es",i,fila.mean())
print("")
print("Media aritmética de cada columna")
suma = 0
for j, columna in enumerate(data):
    for k, fila in enumerate(columna):
        if k == 9:
            suma += data[k][j]
            print("La media aritmética de cada columna", j , suma/10)
            suma = 0
        else:
            suma += data[k][j]
print("")
print("Desviación típica de cada fila")
for i,fila in enumerate(data): #for de cada fila
    print("La desviación típica de cada fila es",i,fila.std())            
print("")
print("Desviación típica de cada columna")
listaSuma = list()
for j, columna in enumerate(data):
    for k, fila in enumerate(columna):
        if k == 9:
            listaSuma.append(data[k][j])
            arr = np.array(listaSuma)
            print("La desviación típica de cada columna", j , arr.std())
            listaSuma.clear()
        else:
            listaSuma.append(data[k][j])


# In[3]:


print("Varianza de cada fila")
for i,fila in enumerate(data): #for de cada fila
    print("La Varianza de cada fila es",i,fila.var())            
print("")
print("Varianza de cada columna")
listaSuma = list()
for j, columna in enumerate(data):
    for k, fila in enumerate(columna):
        if k == 9:
            listaSuma.append(data[k][j])
            arr = np.array(listaSuma)
            print("La desviación típica de cada columna", j , arr.var())
            listaSuma.clear()
        else:
            listaSuma.append(data[k][j])


# In[4]:


dm = pd.DataFrame(data)
dm.describe()


# ## REDES BAYESIANAS ##

# In[5]:


import pyAgrum as gum


# In[6]:


bn = gum.BayesNet() #llama a bayes
print(bn)


# In[7]:


b,e,j,m,a = [bn.add(name,2)for name in "bejma"]
print(b,e,j,m,a)
print(bn)


# In[8]:


bn.addArc(b,a)
bn.addArc(e,a)
bn.addArc(a,j)
bn.addArc(a,m)


# In[9]:


print(bn)


# In[10]:


bn.cpt(b).fillWith([0.999,0.001]) #false,verdadero


# In[11]:


bn.cpt(e).fillWith([0.998,0.002]) #false,verdadero


# In[12]:


bn.cpt(a)[{'b':0,'e':0}] = [0.999,0.001]
bn.cpt(a)[{'b':0,'e':1}] = [0.71,0.29]
bn.cpt(a)[{'b':1,'e':0}] = [0.06,0.94]
bn.cpt(a)[{'b':1,'e':1}] = [0.05,0.95]


# In[13]:


print(bn.cpt(a))


# In[14]:


bn.cpt(j)[{'a':1}] = [0.1,0.9]
bn.cpt(j)[{'a':0}] = [0.95,0.05]
print(bn.cpt(j))


# In[15]:


bn.cpt(m)[{'a':1}] = [0.3,0.7]
bn.cpt(m)[{'a':0}] = [0.99,0.01]
bn.cpt(m)


# In[16]:


ie = gum.LazyPropagation(bn)


# **$P(m)$**

# In[17]:


ie.makeInference()
print(ie.posterior(m))


# **$P(+b,-e,+a,-j,+m)$**

# In[18]:


#P(+a|+b,-e)
ie.setEvidence({'b':1,'e':0})
ie.makeInference()
Pabe = ie.posterior(a)[1]
Pabe


# In[19]:


#P(-j|+a)
ie.setEvidence({'a':1})
ie.makeInference()
Pja = ie.posterior(j)[0]
Pja


# In[20]:


#P(+m|+a)
ie.setEvidence({'a':1})
ie.makeInference()
Pma = ie.posterior(m)[1]
Pma


# In[21]:


#P(+b)
Pb = bn.cpt(b)[1]
Pb


# In[22]:


#P(-e)
Pe = bn.cpt(e)[0]
Pe


# In[23]:


Resultado = Pabe*Pja*Pma*Pb*Pe
print("El resultado es:", Resultado)


# **$P(m |+b,+a)$**
# ## Variables
# * H = e,j
# * Q = m
# * E = b,a

# In[24]:


ie.setEvidence({'b':1,'a':1})
ie.makeInference()
ie.posterior(m)

