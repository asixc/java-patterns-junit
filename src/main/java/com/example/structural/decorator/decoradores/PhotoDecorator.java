package com.example.structural.decorator.decoradores;


import com.example.structural.decorator.Photo;

public abstract class PhotoDecorator extends Photo {

	// elemento que decoramos
	protected Photo photo; // podría ser una DigitalPhoto o un PhotoDecorator porque ambos extienden de Photo

	protected PhotoDecorator(Photo photo) {
		this.photo = photo;
	}
	
	
	

}
