/**
 * Author: Razvan Raducu
 */

var urls = [ "http://imagizer.imageshack.us/v2/800x600q90/922/kRhvy9.jpg",
		"http://imagizer.imageshack.us/v2/800x600q90/922/EiKNO7.jpg",
		"http://imagizer.imageshack.us/v2/800x600q90/923/ZIQi3O.jpg",
		"http://imagizer.imageshack.us/v2/800x600q90/924/Is0H2u.jpg",
		"http://imagizer.imageshack.us/v2/800x600q90/922/Leaj6X.jpg",
		"http://imagizer.imageshack.us/v2/800x600q90/924/g5igyt.jpg",
		"http://imagizer.imageshack.us/v2/800x600q90/924/Xk2LSt.jpg",
		"http://imagizer.imageshack.us/v2/800x600q90/924/JHQboZ.jpg",
		"http://imagizer.imageshack.us/v2/800x600q90/923/AFSZqf.jpg" 
		];

function goRandom() {
	return Math.floor(Math.random() * (urls.length - 1));
	
}

function changeimage(every_seconds) {

	var fondoAleatorio = goRandom();
		// change the image
		document.getElementById("myimage").src = urls[fondoAleatorio];

		// call same function again for x of seconds
		setTimeout("changeimage(" + every_seconds + ")",
				((every_seconds) * 1000));
	

}