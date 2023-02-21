# Simulador SpaceX

El taller consiste en simular un cohete de SpaceX, en concreto un Falcon 9.

## Installation

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
pip install foobar
```

## Usage

```python
import foobar

# returns 'words'
foobar.pluralize('word')

# returns 'geese'
foobar.pluralize('goose')

# returns 'phenomenon'
foobar.singularize('phenomena')
```

## Fases de la misión

### 1.0 Check

Se trata de que todos los micro servicios respondan con un mensaje de Health Check, el micro servicio principal
(este proyecto) espera la siguiente respuesta:
```json
{
  "target": "Nombre micro servicio, por ejemplo 'engine'",
  "status": "Healthy"
}
```
---

### 2.0 Launch

Se trata de la fase de lanzamiento, y los micro servicios que entran en marcha son los siguientes:

#### 2.1 Engine - https://{api-url}/api/engine/launch

El motor tiene que primero presurizar la cámara a `2000` psia y poner él `Mode` en `FULL`, esto quiere decir que el 
atributo `throttle` hay que ajustarlo al 100%. 

**IMPORTANTE**: No se puede ajustar él `Mode` y `throttle` a la potencia
máxima si la cámara no se ha presurizado, tampoco podemos presurizar la cámara de golpe, cada `100 ms` debemos incrementar
`100 psia` hasta llegar al valor de `2000`. Quiere decir que tardará `2 segundos` en `incrementar la presión de 0 a 2000`.

La respuesta de este endpoint al finalizar los ajustes debe ser:
```json
{
  "engine": {
    "mode": "FULL",
    "throttle": 1,
    "chamberPressure": 2000
  }
}
```

#### 2.2 Kerosene Control - https://{api-url}/api/kerosene/launch

El control de Keroseno primero de todo debe activar la `mainValve` y seguidamente comenzar a bombear hasta llegar a 
`fuelPumpPercentage` del 100 % con el valor `1`, donde él `flowRate` irá incrementando hasta `801 kg/s` de combustible al 100%.

**IMPORTANTE**: No se puede ajustar él `fuelPumpPercentage` si la `mainValve` no está abierta. También debemos incrementar
la potencia de bombeo `40 kg/s` cada `100 ms`.

La respuesta de este endpoint al finalizar los ajustes debe ser:
```json
{
  "kerosene": {
    "mainValve": true,
    "ratio": 2.4,
    "fuelPumpPercentage": 1,
    "flowRate": 801
  }
}
```

#### 2.3 LOX Control - https://{api-url}/api/lox/launch

El control de oxígeno líquido primero de todo debe activar la `mainValve` y seguidamente comenzar a bombear hasta llegar a
`fuelPumpPercentage` del 100 % con el valor `1`, donde él `flowRate` irá incrementando hasta `1919 kg/s` de combustible al 100%.

**IMPORTANTE**: No se puede ajustar él `loxPumpPercentage` si la `mainValve` no está abierta. También debemos incrementar
la potencia de bombeo `95 kg/s` cada `100 ms`.

La respuesta de este endpoint al finalizar los ajustes debe ser:
```json
{
  "lox": {
    "mainValve": true,
    "ratio": 2.4,
    "loxPumpPercentage": 1,
    "flowRate": 1919
  }
}
```

![img_1.png](img_1.png)

#### 2.4 Turbo Pump - https://{api-url}/api/turbopump/launch

Para el funcionamiento del `Kerosene` y él `LOX` tenemos una turbina y dos bombas conectadas que son las que bombean los
diferentes combustibles. Esta bomba pone en marcha una turbina con él `throttle` al 100% donde las `rpm` irán incrementando
hasta `36000 rpm` con un resultado total de `hp` de `10000 hp`. Las `rpm` irán incrementando `1800 rpm` cada `100 ms`.

**IMPORTANTE**: Del JSON recibido deberemos comprobar que él `ratio` tanto del `lox` cómo `kerosene` corresponden 
con los `flowRate` del kerosene y lox, la fórmula es la siguiente: `lox flowRate` / `kerosene flowRate` = `ratio`, con 
un margen de error de un 5%.

![img.png](img.png)

---
## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)