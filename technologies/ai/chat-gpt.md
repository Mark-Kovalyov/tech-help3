# Chat GPT

## Model limitations

|Model        |       tokens|
|-------------|-------------|
|gpt-3.5-turbo|4096 токенов |
|gpt-4        |8192
|gpt-4-32k    |32k

## Links

* playground : https://platform.openai.com/playground?mode=chat


```
import os
import openai
openai.organization = "..."
openai.api_key = "...."

question =
prompt =

response = openai.Completion.create(
  engine="text-davinchi-002",
  prompt=prompt,
  max_tokens=50,
  n=1,
  Temperature=0.7
  top=1  
)
```

## Parameters for model

* Mode: complete
* context
* question
* engine = "text-davinci-003"
* Input :
* Instructions :
* Temperature : 0.7
* top_p : 1
* frequency penalty: 0
* presense penalty: 0
* best of: 1
