import { React, useState, useEffect } from "react";
import axios from "axios";

export default function PostsComponent(props) {
  
    const sortMethods = {
      none: { method: (post1, post2) => null },
      ascending: { method: (post1, post2) => (post1.title < post2.title ? -1 : 1) },
      descending: { method: (post1, post2) => (post1.title > post2.title ? -1 : 1) },
    };
  
    return (
        <ul>
          {props.posts.sort(sortMethods[props.sortState].method).map((post, i) => (
            <li key={i}>{post.title}</li>
          ))}
        </ul>
    );
  }
  