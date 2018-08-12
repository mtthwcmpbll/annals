org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/entries'
        headers {
            header('Content-Type', 'application/json;charset=UTF-8')
        }
    }
    response {
        status 200
        body([
            [
                    id: $(regex(uuid())),
                    createdOn: $(regex(iso8601WithOffset())),
                    body: $(regex('.+'))
            ]
        ])
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}