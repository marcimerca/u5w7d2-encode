## Indicazioni 
### NB: durante la post e la put, è necessario (ad esempio su Postman) aggiungere "type": "smartphone" o "type": "computer" per indicare il tipo di dispositivo


## Funzionalità aggiuntive

- Sono stati aggiunti dei controlli durante l'assegnazione di un dispositivo ad un utente, in particolare se il dispositivo ha uno stato: ASSEGNATO, IN_MANUTENZIONE, o DISMESSO, non sarà possibile assegnarlo all'utente e verrà lanciata un'eccezione.
- Il dispositivo sarà assegnabile all'utente (previa verifica della presenza dello stesso), solamente se il suo stato è DISPONIBILE 
- Quando un dipositivo disponibile viene associato ad un utente, lo stato del dispositivo passerà ad ASSEGNATO.
- Infine, se l'utente dovesse essere eliminato, gli eventuali dispositivi ad esso associati cambieranno il loro stato da ASSEGNATO a DISPONIBILE.

- E' stato inoltre aggiunto l'invio automatico di una mail di conferma registrazione all'indirizzo del dipendente una volta inserito correttamente lo stesso.
