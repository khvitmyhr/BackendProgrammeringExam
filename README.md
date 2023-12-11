
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
"customerName": "Odrunn",
"customerEmail": "Odd_ru@hotmail.com",
"addresses": [
{
"street": "Luvisesgate 9",
"zipCode": 3559,
"city": "Oslo"
}
],
"orders": []
}
]

Kan kjøre denne spørringen i h2 for å se customer og address:
SELECT *
FROM customer_address
JOIN address ON address.address_id = customer_address.address_id
JOIN customer ON customer.customer_id = customer_address.customer_id;



Kode for opprette order, men får 500 feil, vet ikke hvorfor

{
"customer": "Kirsti",
"machines": [
{
"machineName": "Chainsaw",
"subassemblies": [
{
"subassemblyName": "Chain",
"parts": [
{
"partName": "Sawtooth"
}
]
}
]
}
]
}