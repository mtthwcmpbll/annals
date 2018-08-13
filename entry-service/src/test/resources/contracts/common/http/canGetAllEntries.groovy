org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/api/entries'
        headers {
            header('Content-Type', 'application/json;charset=UTF-8')
        }
    }
    response {
        status 200
        body([
            [
                    id: $(regex(/[a-f\d]{24}/)),
                    createdOn: $(regex(iso8601WithOffset())),
                    body: $(regex('.+'))
            ]
        ])
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}