export class Enviament {
	  	enviamentId: string;
  		comandaId: string;
  		estatEnviament: string;
     
   
  constructor(values: Object = {}) {
	alert("Construim Enviament");
    Object.assign(this, values);
  }
}
