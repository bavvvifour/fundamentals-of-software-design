import requests
from requests.exceptions import HTTPError


def get_bitcoin_data():
    try:
        response = requests.get('http://localhost:8080/api/bitcoin')
        response.raise_for_status()
        jsonResponse = response.json()

        return jsonResponse

    except HTTPError as http_err:
        print(f'HTTP error occurred: {http_err}')
    except Exception as err:
        print(f'Other error occurred: {err}')