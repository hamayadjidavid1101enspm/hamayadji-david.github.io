# Exercice 9
Est-ce une redéfinition ou une surcharge ?



## Solution
o	L'ajout de void f(B o) dans la classe B est une surcharge (overload), pas une redéfinition.
o	Raison : La signature change (le paramètre est maintenant de type B plutôt que A).
o	La méthode originale void f(A o) existe toujours dans B (via héritage + redéfinition).

