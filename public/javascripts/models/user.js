define([
	'backbone'
], function (Backbone) {
	window.APP = window.APP || {}

	APP.UserModel = (function() {
		return Backbone.Model.extend({
			url: '/users',

			authenticate: function(username, password) {
				
			}
		});	
	}());
})