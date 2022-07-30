'use strict';

import { CharacterControllerDescription} from "../controller/character.controler.description.mjs"

export class CharacterViewdescription {
    #privateBody;

    constructor() {
        document.title = "Personajes rick y morty";
        this.#privateBody = document.querySelector('body');
    }

    init(character) {
        
        const card = this.#privateCreateCard();
        const title = this.#privateCreateTitle();
        title.textContent = "Nombre: "+character.Name;
        const image = this.#privateCreateImage();
        image.src = character.Image;

        const gender = this.#privateCreateGender();
        gender.textContent = "Genero: "+character.Gender;
        card.append(title,image,gender);
        this.#privateBody.append(card);
        return card;
    }

    #privateCreateCard() {
        return document.createElement('div');
    }

    
    #privateCreateImage() {
        return document.createElement('img');
    }

    
    #privateCreateTitle() {
        return document.createElement('h1');
    }

    #privateCreateGender() {
        return document.createElement('h1');
    }
 

}