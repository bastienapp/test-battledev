# Environnement de test Java pour la BattleDev

## Étapes

1. Copier les fichiers de test dans le dossier `resources`

2. Travailler dans la classe `IsoContest`

3. Lancer les tests : clic-droit sur le dossier `test` : *Run 'All Tests'*

Énoncé

Ce challenge est une variante de "Salle au trésor". Ici, votre personnage atterrit au milieu d'un couloir rempli de pièces d'or et de multiplicateurs de richesse. Ce couloir est représenté par une chaîne de caractères (en effet, il est unidimensionnel), dont les caractères peuvent être :
- o : pièce d'or, augmente votre richesse de 1
- * : multiplicateur, double votre richesse
- X : position initiale de votre personnage (ce caractère apparaît exactement une fois)

(Il n'y a pas de case vide.)

Objectif

Le couloir étant étroit, si une case contient un objet, et que vous souhaitez accéder à la partie du couloir qui se trouve derrière, vous êtes obligé de le ramasser (et donc d'activer son effet) si vous voulez libérer le passage. L'objectif est toujours de déterminer la séquence de mouvements qui vous permettra de maximiser votre butin.

Données

Entrée

Ligne 1 : un entier N compris entre 1 et 100, représentant la taille du couloir (nombre de caractères de la chaîne).
Ligne 2 : une chaîne de caractères de longueur N, composée de o, * et X comme indiqué plus haut.

Sortie

Une chaîne de caractères, indiquant la suite de o et * que votre personnage ramassera dans l'ordre s'il se déplace de façon à optimiser le butin final.

Exemple

7
*o*X**o

La sortie attendue est *o**o*, ce qui correspond à :
- d'abord prendre le multiplicateur immédiatement à gauche de la position initiale ;
- ensuite prendre la pièce d'or à gauche ;
- ensuite partir vers la droite et ramasser les 3 objets successivement rencontrés jusqu'au bout du couloir ;
- enfin revenir à l'extrémité gauche et prendre le dernier multiplicateur.