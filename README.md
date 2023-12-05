Litt usikker:

Order must know about machines, but machines do not need to 
know what orders they are part of.
Skal da machines ha manyToOne i seg uansett?

Generelt når den ikke skal vite om den andre, skal da manyToOne
inn i den klassen?


Part --> subassambly --> machine


Lage fabrikk hvor:
Kjøretøy.

1 kjøretøy: traktor
3 subassambly: motor, girkasse, karosseri
part: stempel, sylindre, skruer, tannhjul, aksel, 



kan bruke denne for å poste i customer:
{
"customerId": 2,
"customerName": "Odrunn",
"customerEmail": "Odd_ru@hotmail.com",
"addresses": [
{
"street": "Luvisesgate 9",
"zipCode": 0355,
"city": "Oslo"
}
],
"orders": []
}
]