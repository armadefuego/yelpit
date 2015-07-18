define([
	'backbone'
], function (Backbone) {
	window.APP = window.APP || {};
	APP.LoginView = (function() {
		return Backbone.View.extend({
			events: {
				'click .js-login-button': 'login'
			},

			initialize: function(options) {
				this.model = options.model;
			}, 

			render: function() {
				this.$el.html($('.content').html());
				return this;
			},

			login: function(e) {
				e.preventDefault();
			}
		});
	}());
})
