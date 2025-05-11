# Questions
Définir une méthode String toString() dans la classe Rectangle ? Est-ce en fait une 
définition ou une redéfinition ? Est-il nécessaire de la redéfinir dans la classe 
SlantedRectangle ?

# Reponses 
C'est une redéfinition (@Override), car la méthode toString() existe déjà dans la classe Object (superclasse de toutes les classes Java).
Oui, pour inclure l’angle d’inclinaison