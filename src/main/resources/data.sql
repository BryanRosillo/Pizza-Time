delete from Ingredient_Ref;
delete from Pizza;
delete from Pizza_Order;
delete from Ingredient;

insert into Ingredient(id, name, type) values 
    ('GRBF', 'Ground Beef', 'PROTEIN'),
    ('CARN', 'Carnitas', 'PROTEIN'),
    ('MSHR', 'Mushroom', 'VEGGIES'),
    ('LETC', 'Lettuce', 'VEGGIES'),
    ('CHED', 'Cheddar', 'CHEESE'),
    ('JACK', 'Monterrey Jack', 'CHEESE'),
    ('SLSA', 'Salsa', 'SAUCE'),
    ('SUCR', 'Sour Cream', 'SAUCE');
