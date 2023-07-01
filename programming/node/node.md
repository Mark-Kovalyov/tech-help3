# Node.JS

```
$ node -v
v10.19.0
```

## Upgrade npm
```
npm install -g npm
```

## JS Promises vs Async Awsit

Handle resolved promises
```
promise.then((result) => { })
```

Handle failed (rejected) promises
```
promise.catch((error) => { })
```

## With promise object
```
const axiosRequest = require('axios')
axiosRequest
  .get('http://google.com/api')
  .then(responce => { 
     // okay
  })
  .catch(error => {
     console.error('Error! ${error}')
  })
```
## With async/await

```
async function getActivity() {
   try {
      let responce = await axiosRequest.get('http://google.com/api')
      // okay
   } catch (error) {
      console.error('Error: ${error}')
   }
}


```

