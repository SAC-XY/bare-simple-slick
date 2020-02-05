# とてもシンプルにSlick
--

## QuickStart

`$ docker-compose up -d`

`$ sbt run`


## やってること

### その１

Databaseの接続設定などは`application.conf`に書いたものを
`Database.forConfig("key")`で読み出して使いたかったので
`build.sbt`に
`libraryDependencies += "com.typesafe" % "config" % "1.4.0"`
の依存を加えてTypesafe Configを使用できるようにした


### その２

slickだけでは各種接続ドライバは同梱していないので

`libraryDependencies += "com.h2database" % "h2" % "1.4.200"`

`libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.19"`

で、H2 DatabaseとMySQLのドライバの依存をbuild.sbtに加えた


### その３
MySQLを適当に準備したかったので`docker-compose.yml`で楽をした（雑）
