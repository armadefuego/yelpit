require.config({
	baseUrl: '/assets/javascripts',
	paths: {
		jquery: 'jquery.min',
		backbone: 'backbone',
		bootstrap: 'bootstrap.min',
		lodash: 'lodash.min'
	},
	shim: {
		bootstrap: {
      		deps: ['jquery']
      	},
      	backbone: {
	      	deps: ['jquery', 'lodash'],
	      	exports: 'Backbone'
      	}
	}
});

require(['./app', 'bootstrap'], function() {});