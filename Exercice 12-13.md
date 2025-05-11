# Questions
Dans la classe Rectangle a été définie une méthode boolean contains(Rectangle). Cette 
méthode doit-elle être redéfinie dans la classe SlantedRectangle ? Quels cas ne sont pas 
couverts par cette redéfinition ? On ajoute alors une méthode boolean 
contains(SlantedRectangle) dans les classes Rectangle et SlantedRectangle. Quels 
cas ne sont toujours pas couverts par ces ajouts ? 

# Reponses
Cas non couverts :

Un rectangle non incliné contenant un rectangle incliné (la méthode actuelle ne gère pas correctement la rotation)

Deux rectangles inclinés avec des angles différents

Les cas où seule une partie du rectangle incliné est contenue dans l'autre
