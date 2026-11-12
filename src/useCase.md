# Use case-beskrivelser – Streamingtjeneste

Aktør i alle use cases: **Bruger**

---

### UC1: Start tjeneste

- **Forudsætning:** Programmet startes.
- **Sunny day:** Systemet indlæser film, serier og brugere fra filerne og viser startmenuen med valgene "Opret bruger" (UC2), "Log ind" (UC3) og "Afslut" (UC13).
- **Rainy day:** En af datafilerne kan ikke læses (IOException). Systemet skriver "Kunne ikke indlæse data. Programmet lukkes." og afslutter pænt i stedet for at crashe.
- **Rainy day:** Brugeren skriver noget, der ikke er et menuvalg. Systemet skriver "Ugyldigt valg." og viser startmenuen igen.

### UC2: Opret bruger

- **Forudsætning:** Brugeren har valgt "Opret bruger" i startmenuen.
- **Sunny day:** Brugeren indtaster brugernavn og password. Systemet gemmer brugeren i filen `userData.csv`, så brugeren også findes næste gang programmet starter. Brugeren sendes tilbage til startmenuen og kan nu logge ind (UC3).
- **Rainy day:** Brugernavnet er allerede i brug. Systemet skriver "Brugernavnet er allerede i brug." og sender brugeren tilbage til startmenuen.
- **Rainy day:** Brugeren kan ikke gemmes i filen. Systemet informerer brugeren om fejlen.

### UC3: Log ind

- **Forudsætning:** Brugeren har valgt "Log ind" i startmenuen.
- **Sunny day:** Brugeren indtaster brugernavn og password. Systemet finder en bruger, hvor begge dele passer, og viser hovedmenuen (UC4).
- **Rainy day:** Brugernavn eller password er forkert. Systemet skriver "Forkert brugernavn eller password." og sender brugeren tilbage til startmenuen, hvor brugeren kan prøve igen eller oprette en ny bruger (UC2).

### UC4: Hovedmenu

- **Forudsætning:** Brugeren er logget ind.
- **Sunny day:** Hovedmenuen viser følgende valg:
  1. Søg efter film eller serie (UC5)
  2. Søg efter kategori (UC6)
  3. Se sete medier (UC7)
  4. Se gemte medier (UC8)
  0. Log ud – brugeren sendes tilbage til startmenuen (UC1)
- **Rainy day:** Brugeren skriver noget, der ikke er et menuvalg. Systemet skriver "Ugyldigt valg." og viser hovedmenuen igen.

### UC5: Søg medie

- **Forudsætning:** Brugeren har valgt "Søg efter film eller serie" i hovedmenuen.
- **Sunny day:** Brugeren indtaster en titel eller en del af en titel. Systemet søger i både film og serier (uden at skelne mellem store og små bogstaver) og viser en nummereret liste over resultaterne. Brugeren kan vælge et medie (UC9).
- **Rainy day:** Ingen medier matcher søgningen. Systemet skriver "Listen er tom." og sender brugeren tilbage til hovedmenuen.

### UC6: Søg kategori

- **Forudsætning:** Brugeren har valgt "Søg efter kategori" i hovedmenuen.
- **Sunny day:** Brugeren indtaster en kategori, fx "War". Systemet viser en nummereret liste over alle film og serier i kategorien. Brugeren kan vælge et medie (UC9).
- **Rainy day:** Kategorien findes ikke, eller der er ingen medier i den. Systemet skriver "Listen er tom." og sender brugeren tilbage til hovedmenuen.

### UC7: Se sete medier

- **Forudsætning:** Brugeren har valgt "Se sete film" i hovedmenuen.
- **Sunny day:** Systemet viser en nummereret liste over de medier, brugeren har afspillet. Brugeren kan vælge et medie (UC9), fx for at se det igen.
- **Rainy day:** Brugeren har ikke set noget endnu. Systemet skriver "Listen er tom." og sender brugeren tilbage til hovedmenuen.

### UC8: Se gemte medier

- **Forudsætning:** Brugeren har valgt "Se gemte film" i hovedmenuen.
- **Sunny day:** Systemet viser en nummereret liste over de medier, brugeren har gemt til senere. Brugeren kan vælge et medie (UC9).
- **Rainy day:** Brugeren har ikke gemt noget. Systemet skriver "Listen er tom." og sender brugeren tilbage til hovedmenuen.

### UC9: Vælg medie

- **Forudsætning:** Brugeren får vist en liste fra UC5, UC6, UC7 eller UC8.
- **Sunny day:** Brugeren skriver nummeret på et medie. Systemet viser det valgte medie og valgene "Afspil" (UC10), "Gem til senere" (UC11), "Fjern fra gemte" (UC12) og "Tilbage".
- **Rainy day:** Brugeren skriver bogstaver i stedet for et tal. Systemet skriver "Skriv venligst et tal." og spørger igen.
- **Rainy day:** Brugeren skriver et nummer, der ikke findes på listen. Systemet skriver "Ugyldigt nummer." og sender brugeren tilbage til hovedmenuen.

### UC10: Afspil medie

- **Forudsætning:** Brugeren har valgt et medie (UC9) og valgt "Afspil".
- **Sunny day:** Mediet afspilles. En film skriver fx "The Godfather afspilles nu...", og en serie skriver også antallet af sæsoner. Mediet tilføjes automatisk til brugerens liste over sete medier (UC7). Derefter fortsætter brugeren til UC14.
- **Rainy day:** Mediet er allerede på listen over sete medier. Det afspilles igen, men tilføjes ikke til listen en gang til.

### UC11: Gem medie

- **Forudsætning:** Brugeren har valgt et medie (UC9) og valgt "Gem til senere".
- **Sunny day:** Mediet tilføjes til brugerens liste over gemte medier (UC8), og systemet bekræfter det.
- **Rainy day:** Mediet er allerede gemt. Det tilføjes ikke en gang til, så det ikke står dobbelt på listen.

### UC12: Fjern gemt medie

- **Forudsætning:** Brugeren har valgt et medie (UC9) og valgt "Fjern fra gemte".
- **Sunny day:** Mediet fjernes fra brugerens liste over gemte medier, og systemet bekræfter det.
- **Rainy day:** Mediet er ikke på listen over gemte medier. Der sker ingen ændring.

### UC13: Afslut tjeneste

- **Forudsætning:** Brugeren er i startmenuen (logger man ud fra hovedmenuen, kommer man tilbage hertil).
- **Sunny day:** Brugeren vælger "Afslut". Systemet skriver "Programmet afsluttes." og lukker.

### UC14: Afslut medie

- **Forudsætning:** Et medie er blevet afspillet (UC10).
- **Sunny day:** Afspilningen er slut, og brugeren føres tilbage til hovedmenuen (UC4).
