$('#uploadform').submit(function(event) {
	event.preventDefault();

	var formData = new FormData();
	var fileinput = $('#fileinput');
	formData.append('file', fileinput[0].files[0]);
	formData.append('season', $('#season').val());
	formData.append('weeknum', $('#weeknum').val());
	
	$.ajax({
	    url: 'upload',
	    data: formData,
	    cache: false,
	    contentType: false,
	    processData: false,
	    type: 'POST',
	    success: function(resp){
			$('#results').empty().html(resp.result);
	    }
	});								
	
	return false;
});
        
function refreshSeasonList(seasons) {
	var seasonSelect = $('#season');
	$(seasonSelect).empty();
	for(var i = 0; i < seasons.length; i++) {
		var season = seasons[i];
		$(seasonSelect).append( $('<option>', {value: season.seasonid }).text(season.year));
	}
}

function refreshWeekList(weeks) {
	var weekSelect = $('#weeknum');
	$(weekSelect).empty();
	for(var i = 0; i < weeks.length; i++) {
		var week = weeks[i];
		$(weekSelect).append( $('<option>', {value: week.weeknum }).text(week.displayName));	
	}
}

function getWeeksForSeason() {
	var season = $('#season').val();
	$.getJSON('upload/seasons/' + season, 
		function(weeks) {
			refreshWeekList(weeks);
		}
	);
}

function addSeason() {
	var newSeason = $('#newSeason').val();
	
	$.ajax({
	    url: 'upload/seasons/',
	    data: {'season' : newSeason},
	    cache: false,
	    contentType: false,
	    processData: false,
	    type: 'POST',
	    success: function(seasons) {
			refreshSeasonList(seasons);
		}
	});	
}

function deleteSeason() {
	alert('delete season');
}

function refreshWeekList(weeks) {
	var weekSelect = $('#weeknum');
	$(weekSelect).empty();
	for(var i = 0; i < weeks.length; i++) {
		var week = weeks[i];
		$(weekSelect).append( $('<option>', {value: week.weeknum }).text(week.displayName));	
	}
}

function addWeek() {
	alert('add week');
}

function deleteWeek() {
	alert('delete week');
}
