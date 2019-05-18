# Nowoczesne języki programowania obiektowego I

## Author
Marek Hacieja

## Tasks(PL)
### 1.terminal (Composite Pattern) 
Z punktu widzenia systemu plików systemu operacyjnego, zapis dotyczący samego pliku jak i folderu (katalogu) jest dość podobny. Plik oraz katalog mają swoją nazwę, przy listowaniu zawartości dysku takie nazwy są wypisywane, niezależnie od tego, czy mamy doczynienia z plikiem czy folderem, przy czym nazwy folderów są w pewien sposób wyróżniane (proszę sprawdzić zlecenia listowania zawartości dysku/folderów w swoim ulubionym systemie operacyjnym). Foldery mogą zawierać w sobie pliki i/lub podfoldery. W analogiczny sposób można potraktować dysk, który ma swój literowy identyfikator oraz nazwę. Proszę zidentyfikować prosty wzorzec projektowy pozwalający na opisanie powyższych zależności oraz, z wykorzystaniem tego wzorca, napisać program pozwalający na:
* Założenie hipotetycznego systemu plików, struktura może być zdefiniowana sztywno w programie (zapisana w kodzie). Proszę programowo zbudować przykładową strukturę.
* Symulowanie „linii poleceń” — program ma pozwalać użytkownikowi na sprowadzanie poleceń typu dir, cd .., cd <nazwa podkatalogu>. A zatem użytkownik może poruszać się po zdefiniowanej strukturze dysku, mając możliwość przeglądania zawartości odwiedzanych katalogów. Zakładamy, że na starcie katalogiem domyślnym jest główny katalog symulowanego systemu plików.

### 2. html (Decorator Pattern)
W języku HTML każdy fragment tekstu może być na różne sposoby „otagowany”, czyli otoczony odpowiednimi znacznikami. Załóżmy, że mamy klasę PlainText przechowującą fragment tekstu. Klasa ta posiada funkcję składową void write(), która wypisuje do strumienia wyjściowego programu tekst zapisany w obiekcie tej klasy. Obiekt klasy PlainText może być „otagowany” znacznikami <p'>, <strong'>, <em'>, <mark'>. 
Każdy dozwolony w HTML układ „otagowania” tekstu tymi znacznikami jest możliwy. „Otagowany” tekst ma być wyprowadzany do strumienia wyjściowego funkcją składową posiada funkcję składową void write(). Proszę zidentyfikować prosty wzorzec projektowy pozwalający na wyprowadzenie do strumienia wyjściowego „otagowanego” w dowolny sposób tekstu obiektu klasy PlainText. Bazując na zidentyfikowanym wzorcu proszę napisać program (może być konsola), który:
* Pozwoli użytkownikowi na wprowadzenie jednolinijkowego tekstu.
* Pozwoli na wybranie jakimi znacznikami ma być „otagowany” wprowadzony tekst (znaczniki wskazane wyżej), dozwolona jest dowolna kombinacja znaczników.
* Wyprowadzi do strumienia wyjściowego odpowiednio „otagowany” tekst HTML.

### 3. factoryhtml (Simple Factory Pattern)
Jak opisano w zadaniu poprzednim, w języku HTML każdy fragment tekstu może być na różne sposoby „otagowany”. Proszę napisać prosty program (może być konsola), który:
* Pozwoli użytkownikowi na wprowadzenie jednolinijkowego tekstu.
* Wyświetli proste menu zawierające wybrane znaczniki HTML (np. strong, p, em, mark), menu ma pozwolić użytkownikowi na jednokrotny wybór znacznika jakim ma być otoczony wcześniej wprowadzony tekst.
* Wyprowadzi do strumienia wyjściowego tekst otoczony wybranym w menu znacznikiem.
Program ma zostać zaimplementowany z wykorzystaniem wzorca Prosta Fabryka lub Metod Fabrykująca.

### 4. sorting (Observer Pattern)
Tablice można sortować różnymi metodami. W bibliotekach większości języków zaimplementowane są szybkie algorytmy sortowania. Jakie są jednak rzeczywiste różnice pomiędzy tzw. prostymi algorytmami sortowania a np. algorytmem sortowania szybkiego? Proszę napisać program, który pozwoli na przeprowadzenie zautomatyzowanych eksperymentów pozwalających sprawdzić efektywność sortowania. Program przeprowadzić automatyczne testy, polegające na utworzeniu tablicy, zapełnieniu jej losowymi danymi, oraz posortowaniu jej różnymi metodami (pomiar czasu). Proszę utworzyć tablice o: kilkudziesięciu elementach, kilkuset elementach, kilku tysiącach elementów (może uda się dla większego rozmiaru). Sortowanie każdą metodą mam być powtórzone 10 razy a wyniku uśrednione. Proszę przetestować dwie proste metody sortowania (np. bąbelkowe, proste wybieranie), sortowanie szybkie oraz sortowanie dostępne w bibliotekach wybranego języka. Uwaga: program jest prosty, wiem, że mało ciekawy. Ale on ma być poligonem doświadczalnym dla przećwiczenia stosowania wzorców projektowych. Proszę uważnie przemyśleć jakie można zastosowań w tym programie wzorce projektowe, oraz sporządzić prostą, np. konsolową implementację programu wraz z komentarzami wskazującymi jakie wzorce, co czego, i w których miejscach zostały zastosowane.
