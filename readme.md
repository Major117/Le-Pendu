# ***Jeu du Pendu*** 


## **Description du jeu :**

Le Pendu est un jeu consistant à trouver un mot en devinant quelles sont les lettres qui le composent. 
Le jeu se joue traditionnellement à deux, dans notre cas s'est l'ordianteur qui choisie des mots au hasards
dans une liste déjà écrite, l'objectif est de trouvée le mot en moins de 7 erreurs.



## **description de l’implémentation technique du jeu :** 

![alt text](https://zupimages.net/up/19/45/mrfz.png)


- On rentre dans la 1er boucle *"do While"* :
```
.On initialise le nombre d'erreur a 7.
.On transforme notre mot en tableaux de caractére.
.On transforme notre mot a deviner en tableaux de underscore qui prend en paramétre le 1er tableaux de caractére.
```
- On rentre maintenant dans notre boucle principale *"While"* et tant que notre condition victoire et notre condition de défaite retourne "true", alors on reste dans cette boucle:
```
.On appelle la methode afficher().
.On récupère la lettre taper par l'utilisateur (qu'on transforme en minuscule et si il tape un mot on récupére 
seulement le 1er caractére)
.On initialise "erreur" qui est un boolean et on appelle la méthode chercheEtRemplace() qui vérifie si la lettre
 choisi par l'utilisateur et bien dans le mot a deviner,
  et retourne un boolean.
.Si erreur retourne false (si il retourne true alors on entre pas dans le "if").
.Alors on retire -1 a Nb Erreur.
```
- Si on sort de la boucle principal, c'est que une des deux condition a retourné "false" alors on les vérifies.
```
.Le premier "if" (condition de victoire) compare si le mot choix au débart et le mot a deviner est 
strictement égal et si oui, alors il imprime un message dédié.
```
```
.Le deuxième "if" (condition de défaite) vérifie si le nombre d'erreur est égal a zero et 
si oui il imprime un message dédié.
```
- Maintenant on entre dans notre 2ème "do While".
```
.On demande à l'utilisateur si il veux rejouer; 
.On lui demande de repondre en tapant "o" (oui) ou "n" (non). 
.Et tant que l'utilisateur n'a pas taper un des caractères demandé, alors on répéte la boucle.
```
- Pour finir on arrive dans la condition de notre 1er "Do While" 
et si l'utilisateur a choisi de rejouer alors on répéte la boucle sinon on sort de la boucle.

Si l'utilasateur décide d'arréter, on imprime un message et on ferme le scanner.
 



## **la notice d’utilisation :** 

La console chosie un mot dans la liste ,l'affiche sous forme caché et demande a l'utilisateur de chosir une lettre.
A ce moment le joueur doit taper une lettre, si la lettre est bonne, l'ordinateur réaffiche le mot et fait apparaitre la lettre;
sinon le joueur verra son nombre de tour décrémenter de 1 pour chaque erreur. Après la victoire ou la défaite du joeur, l'ordinateur
propsera a l'utilisateur si il veux rejouer ou non, pour cela il devra taper sur "o" (oui) pour rejouer ou sur "n" (non) pour arréter,
et la console se fermer.



## **un exemple d’utilisation :**

#### exemple d'une victoire :

![alt text](https://zupimages.net/up/19/45/4kk5.png)

#### exemple de défaite : 



![alt text](https://zupimages.net/up/19/45/sd4z.png)