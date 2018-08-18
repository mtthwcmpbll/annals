import React, {Component} from 'react';

class Entry extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div class="Entry">
                {this.props.entry.body}
            </div>
        );
    }
}

export default Entry;
