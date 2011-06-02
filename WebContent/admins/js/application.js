YUI().use('node', 'io', function(Y) {

	var showApplication = function(e) {
		
		var current = Y.one('#currentApplication');
		var callback = function(id, r, args) {
			
			current.setContent(r.responseText);
		};
		
		Y.io('applicationServlet?id='+ this.get('id'), { method: 'GET' });
		Y.on('io:success', callback, this);
	};
	
	var showButtons = Y.all('.showButton');
	
	showButtons.each( function(n) {
		
		n.on('click', showApplication);
	});
	
});