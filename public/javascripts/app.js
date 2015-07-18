define([
	'backbone',
	'views/login',
	'models/user',
	'views/register',
], function (Backbone) {
	var Router = Backbone.Router.extend({
		routes: {
			'': 'index',
			'register': 'register'
		},

		register: function() {
			this.currentView = new APP.RegisterView({model: new APP.UserModel()});
			$('.content').html(this.currentView.render().el);			
		},

		index: function() {
			this.currentView = new APP.LoginView({model: new APP.UserModel()});
			$('.content').html(this.currentView.render().el);
		}
	});
	var router = new Router();
	Backbone.history.start({pushState: true}); 
} );
