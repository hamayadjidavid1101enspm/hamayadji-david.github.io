# Questions Exercice 3
De quelles méthodes hérite la classe SlantedRectangle ? Redéfinir celles qui le nécessitent. 

# Reponses
La classe SlantedRectangle hérite de toutes les méthodes publiques et protégées de Rectangle, notamment :

getX(), getY(), getWidth(), getHeight() (accesseurs)

area() / surface() (calcul de surface)

translate(dx, dy) (translation)

contains(Point p) (test d'inclusion d'un point)

contains(Rectangle r) (test d'inclusion d'un rectangle)

toString() (représentation textuelle)

equals(Object obj) (comparaison)

# Questions Exercice 5
Est-ce que la classe Dessin définie précédemment peut contenir des rectangle inclinés ? Estce que les méthodes surface, contains et hull de la classe Dessin fonctionnent encore 
correctement ?

# Reponses 
Oui, mais avec des limitations :

Si Dessin utilise un tableau de Rectangle: Vous pouvez y stocker des SlantedRectangle grâce au polymorphisme (un SlantedRectangle est un Rectangle);
Si Dessin utilise des méthodes spécifiques à Rectangle qui ne sont pas redéfinies dans SlantedRectangle (comme contains), les résultats peuvent être incorrects (voir partie 2).

(a) Méthode surface()
Comportement :
La surface d’un SlantedRectangle est identique à celle d’un Rectangle (width * height), car la rotation ne change pas l’aire.
✅ Fonctionne correctement

b) Méthode contains(Point p)
Problème :
Si Dessin utilise la méthode contains de Rectangle sans vérifier le type
❌ Ne fonctionne pas correctement :
La méthode contains de Rectangle ne tient pas compte de l’angle d’un SlantedRectangle → faux positifs/negatifs.

Solution :
S’assurer que SlantedRectangle redéfinit bien contains(Point p)


(c) Méthode hull()
Problème :
Le rectangle englobant (hull) doit tenir compte de tous les coins des rectangles inclinés.
❌ Version naïve incorrecte
✅ Solution :

Pour chaque SlantedRectangle, calculer ses 4 coins après rotation.

Agrandir hull pour couvrir tous les coins.

