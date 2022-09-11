
-- INSERT SAMPLE DATA

insert into recipe (category, instructions, name, servefor, code)  values ('veg', 'put in pan', 'Margareta', 4, 'VEG_MARG4'); 
insert into ingredient (recipe_code, name) values ('VEG_MARG4', 'pine');

insert into recipe (category, instructions, name, servefor, code)  values ('veg', 'put in oven', 'Margareta', 2, 'VEG_MARG2'); 
insert into ingredient (recipe_code, name) values ('VEG_MARG2', 'potato');

insert into recipe (category, instructions, name, servefor, code)  values ('non-veg', '', 'Italian Pizza', 2, 'ITALN2'); 
insert into ingredient (recipe_code, name) values ('ITALN2', 'corn');