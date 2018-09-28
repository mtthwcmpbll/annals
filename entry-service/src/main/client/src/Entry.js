import React, {Component} from 'react';

class Entry extends Component {
    render() {
        return (
            <div class="Entry">
                {this.props.entry.body}
            </div>
        );
    }
}

export default Entry;
