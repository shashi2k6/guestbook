## `Guestbook :`


### `Use case 1:`

Any visitor can post their name and a comment to the Guestbook.


| `URI`                             | `Method` | `Description`                                          |
|---------------------------------|--------|------------------------------------------------------|
|/entries                        |GET     | Get a all the Guest book entries from the memory.


### `Use case 2:`

All visitors can see a list of every entry in the Guestbook.

| `URI`                             | `Method` | `Description`                                          |
|---------------------------------|--------|------------------------------------------------------|
|/entries                        |POST     | Add the Guest book entries to the memory.

### `URLs : `

https://guestbookentries.herokuapp.com/entries

### `Commands to deploy as container :`

`1. heroku login`

`2. heroku container:login`

`3. heroku git:remote -a guestbookentries <Project name in Heroku portal>`

`4. heroku container:push web`

`5. heroku container:release web`
