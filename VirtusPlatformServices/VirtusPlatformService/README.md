# Depencare Marketplace back

## Requirements
1. jdk >= 1.8
2. gradle >= 4
3. postgresql 12.3

## Development

### Configuration
1. Verify your postgresql authentication at file `/src/main/resources/application-dev.yml`
2. Verify active profile must be `dev`

### Run
`./gradlew bootRun`

### Build
`./gradlew build`

## Deployment

### Configuration
1. Verify your postgresql authentication at file `/src/main/resources/application-prod.yml`
2. Verify active profile must be `prod`

### Build
1. Execute command `./gradlew build`
2. `.war` can be found in `build/libs`

## Docker

### Run
`./start_dev.sh`

#### NOTE: For use with Docker your `datasource.url` at `/src/main/resources/application.yml` should be `jdbc:postgresql://virtus_web_db:5432/virtus_main_db`, for use without docker must be `jdbc:postgresql://localhost:5432/virtus_main_db`