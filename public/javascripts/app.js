define([
	'backbone'
], function (Backbone) {
	var Router = Backbone.Router.extend({
		routes: {
			'': 'index'
		},

		index: function() {
		}
	});
	var router = new Router();
	Backbone.history.start(); 
} );