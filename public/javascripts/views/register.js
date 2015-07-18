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
				this.model.bind('invalid', this.showErrors, this);
			}, 

			render: function() {
				this.$el.html($('.content').html());
				return this;
			},

			showErrors: function(user, errors) {
			    this.$el.find('.error').removeClass('error');
			    this.$el.find('.alert').html(_.values(errors).join('<br>')).show();
			    // highlight the fields with errors
			    _.each(_.keys(errors), _.bind(function (key) {
			      this.$el.find('*[id=' + key + ']').addClass('error');
			    }, this));
			},

			register: function(e) {
				e.preventDefault();
				this.model.set({
					email: this.$el.find('input[id=email]').val(),
					password: this.$el.find('input[id=password]').val(),
					passwordConfirmation: this.$el.find('input[id=confirmpassword]').val()
				});
				this.model.save();
			}
		});
	}());
})