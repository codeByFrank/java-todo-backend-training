# Todo Backend

Ein Spring-Boot-Backend für die Todo-Frontend-Übung bei neue fische. Todos werden in MongoDB gespeichert.

## API-Endpunkte

| Methode | Endpunkt | Funktion |
|---|---|---|
| `GET` | `/api/todo` | Alle Todos abrufen |
| `POST` | `/api/todo` | Todo anlegen |
| `GET` | `/api/todo/{id}` | Todo anhand der ID abrufen |
| `PUT` | `/api/todo/{id}` | Todo aktualisieren |
| `DELETE` | `/api/todo/{id}` | Todo löschen |

Ein Todo enthält eine Beschreibung und einen Status, zum Beispiel `OPEN` oder `IN_PROGRESS`. Die ID wird vom Backend vergeben.

## Beispiel für POST und PUT

```json
{
  "description": "spazieren gehen",
  "status": "OPEN"
}