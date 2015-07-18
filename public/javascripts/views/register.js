define([
	'backbone'
], function (Backbone) {
	window.APP = window.APP || {};
	APP.RegisterView = (function() {
		return Backbone.View.extend({
			events: {
				'click .js-register-button': 'register'
			},

			initialize: function(options) {
				this.model = options.model;
			}, 

			render: function() {
				this.$el.html($('.content').html());
				return this;
			},

			register: function(e) {
				e.preventDefault();
				this.model.save();
			}
		});
	}());
})