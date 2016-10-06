<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
$(function() {
	var regionId = 0;
	var regionSelect = $('select#region');
	regionSelect.chosen();
	
	$.ajax({
		url:'/country',
		type:'GET',
		success:function(countries){
			var select = $('#country');
			for(var i = 0; i < countries.length; i++){
				var option = $('<option>', {
					value:countries[i].id,
					text:countries[i].name
				});
				select.append(option);
			}
			select.chosen();
		}
	});
	$('#country').change(function() {
		regionSelect.empty();
		regionSelect.trigger("chosen:updated");
		var countryId = $(this).val();
		regionSelect.trigger("chosen:updated");
		$.ajax({
			url:'/country/region/'+countryId,
			type:'GET',
			success:function(regions){
				var select = $('#region');
				for(var i = 0; i < regions.length; i++){
					var option = $('<option>', {
						value:regions[i].id,
						text:regions[i].name
					});
					select.append(option);
				}
				regionSelect.trigger("chosen:updated");
			}
		});
	});
	$.ajax({
		url:'/country',
		type:'GET',
		success:function(countries){
			var select = $('select[name=countryId]');
			for(var i = 0; i < countries.length; i++){
				var option = $('<option>', {
					value:countries[i].id,
					text:countries[i].name
				});
				select.append(option);
			}
			select.chosen();
		}
	});
	findAll();
	function findAll() {
		$.ajax({
			url:'/region',
			type:'GET',
			success:function(regions){
				var parent = $('div.col-md-7');
				parent.children('div').remove();
				var row = $('<div>',{
					class:'row'
				});
				parent.append(row);
				row.append($('<div>',{
					class:'col-md-3 col-xs-3',
					text:"Region"
				}));
				row.append($('<div>',{
					class:'col-md-3 col-xs-3',
					text:"Country"
				}));
				row.append($('<div>',{
					class:'col-md-3 col-xs-3',
					text:"Update"
				}));
				row.append($('<div>',{
					class:'col-md-3 col-xs-3',
					text:"Delete"
				}));
				for(var i = 0; i < regions.length; i++){
					var row = $('<div>',{
						class:'row'
					});
					parent.append(row);
					var name = $('<div>',{
						class:'col-md-3 col-xs-3',
						text:regions[i].name
					});
					row.append(name);
					var countryName = $('<div>',{
						class:'col-md-3 col-xs-3',
						text:regions[i].countryName
					});
					row.append(countryName);
					var update = $('<div>',{
						class:'col-md-3 col-xs-3'
					});
					row.append(update);
					var updateButton = $('<button>',{
						class:'btn btn-primary',
						value:regions[i].id,
						text:'update'
					});
					update.append(updateButton);
					var deleteDiv = $('<div>',{
						class:'col-md-3 col-xs-3'
					});
					row.append(deleteDiv);
					var deleteButton = $('<button>',{
						class:'btn btn-primary',
						value:regions[i].id,
						text:'delete'
					});
					deleteDiv.append(deleteButton);
				}
				updateDelete();
			}
		});
	}
	function updateDelete() {
		$('div.row div.col-md-3 button').click(function(event) {
			var target = $(event.target);
			var id = target.val();
			var text = target.text();
			if(text == "delete"){
				$.ajax({
					url:'/region/'+id,
					type:'DELETE',
					success:function(){
						target.parent().parent().remove();
					}
				});
			}else{
				$.ajax({
					url:'/region/'+id,
					type:'GET',
					success:function(region){
						$('input[name=name]').val(region.name);
						$('option[value='+region.countryId+']').attr("selected", "selected");
						$('select[name=countryId]').trigger("chosen:updated");
						regionId = region.id;
					}
				});
			}
		});
	}
	
	$('#regionForm').submit(function(event) {
		event.preventDefault();
		var json = JSON.stringify({
			id:regionId,
			name:$('input[name=name]').val(),
			countryId:$('select[name=countryId]').val(),
			countryName:null
		});
		if(regionId==0){
			$.ajax({
				url:'/region',
				type:'PUT',
				data:json,
				contentType:"application/json",
				success:function(){
					$('input[name=name]').val('');
					findAll();
					regionId = 0;
				}
			});
		}else{
			$.ajax({
				url:'/region',
				type:'POST',
				data:json,
				contentType:"application/json",
				success:function(){
					$('input[name=name]').val('');
					findAll();
					regionId = 0;
				}
			});
		}
	});
});
</script>
<div class="row-fluid">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="">
				<ul class="nav navbar-nav">
					<li><a href="/admin/country">Country</a></li>
					<li><a href="/admin/ingredient">Ingredient</a></li>
					<li><a href="/admin/measuringSystem">Measuring System</a></li>
					<li><a href="/admin/recipe">Recipe</a></li>
					<li><a href="/admin/ingredientAmount">Amount and
							ingredient</a></li>
					<li><a href="/admin/country/recipe">Recipe country</a></li>
					<li class="active"><a href="/admin/region">Region</a><span
						class="sr-only">(current)</span></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row-fluid">
	<div class="col-md-3"></div>
	<div class="col-md-7" >
		<form class="form-inline" id="regionForm">
			<div class="form-group">
				<select name="countryId">
					<option value="0">Country</option>
				</select> <input name="name" class="form-control" placeholder="Region name" />
				<button type="submit" class="btn btn-primary">Create Region</button>
			</div>
		</form>
	</div>
	<div class="col-md-2">
		<select id="country">
			<option value="0">Country</option>
		</select>
		<select id="region">
			<option value="0">Region</option>
		</select>
	</div>
</div>