USE kea;

-- What are all primary types (show a list of the ones in the dataset)
SELECT DISTINCT (primary_type) AS PrimaryTypes
FROM pokemon;

-- What are the average defence for all pokemon?
SELECT AVG(defence) AS defenceAVG
FROM pokemon;

-- What are the average hp for (primary) grass types?
SELECT AVG(hp)
FROM pokemon
WHERE primary_type = 'Grass';

-- How many pokemon exists pr. primary type?
SELECT primary_type, COUNT(pokedex_number)
FROM pokemon
GROUP BY primary_type;

-- How many fire pokemon has higher hp than the average pokemon?
SELECT COUNT(pokedex_number) AS fire_hp_over_AVG
FROM pokemon
WHERE hp > (SELECT AVG(hp) FROM pokemon)
  AND primary_type = 'Fire';

-- What primary type are the fastest?
SELECT primary_type, AVG(speed)
FROM pokemon
GROUP BY primary_type
ORDER BY AVG(speed) DESC
LIMIT 1;




