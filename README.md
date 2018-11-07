# Environnement de test Java pour la BattleDev

## Étapes

1. Copier les fichiers de test dans le dossier `resources`

2. Travailler dans la classe `IsoContest`

3. Lancer les tests : clic-droit sur le dossier `test` : *Run 'All Tests'*

## Sujet

### Objectif

Il y a fort longtemps, dans une galaxie lointaine, très lointaine… Vous habitez une planète désertique à deux soleils, et êtes le modeste exploitant d’une ferme hydroponique. Votre exploitation est représentée par une grille carrée sur laquelle sont disposés des évaporateurs d’humidité. Chaque évaporateur d’humidité irrigue et rend ainsi cultivables les 8 cases qui lui sont adjacentes (on ne peut rien cultiver sur une case contenant un évaporateur d’humidité).

Le but de ce challenge est de déterminer le nombre de cases cultivables de votre exploitation.


### Données

#### Entrée

* Ligne 1 : un entier N compris entre 3 et 50 représentant la taille de votre ferme (une grille carrée de dimension N x N)
* Lignes 2 à N+1 : les lignes de la carte représentées par des chaînes de N caractères. Les caractères de la ligne sont soit X (un évaporateur) soit . (une case vide).

#### Sortie

Un entier représentant le nombre de cases cultivables de votre ferme.